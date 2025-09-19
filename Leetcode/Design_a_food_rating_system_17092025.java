package Leetcode;
/*here as new element is added either we have to make pq again or do something
so we mark the one which is changed i.e. we remove its food of i and put
their empty string such that it can be recognised*/
// time - change streak - o(logn), higest streak - total(n+m)log(n+m)
// space - O(n+m)
// leetcode - 2353
class FoodRatings {
    public class Info{
        String food;
        String cuisine;
        int rating;
        public Info(String food,String cuisine,int rating){
            this.food=food;
            this.cuisine=cuisine;
            this.rating=rating;
        }
    }
    Map<String,PriorityQueue<Info>> cuisineMap;
    Map<String, Info> foodMap;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap=new HashMap<>();
        foodMap=new HashMap<>();
        for(int i=0; i<foods.length; i++){
            Info combo=new Info(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],combo);
            if(cuisineMap.containsKey(cuisines[i])){
                cuisineMap.get(cuisines[i]).add(combo);
            }
            else{
                PriorityQueue<Info> pq=new PriorityQueue<Info>(new Comparator<Info>(){

                    public int compare(Info a,Info b){
                        int result=b.rating-a.rating;
                        if(result==0){
                            return (a.food).compareTo(b.food);
                        }
                        return result;
                    }
                });
                pq.add(combo);
                cuisineMap.put(cuisines[i],pq);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        Info prev=foodMap.get(food);
        Info curr= new Info(food,prev.cuisine,newRating);
        foodMap.put(food,curr);
        prev.food="";
        cuisineMap.get(prev.cuisine).add(curr);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Info> pq = cuisineMap.get(cuisine);
        while( pq.peek().food.equals("")){
            pq.remove();
        }
        return pq.peek().food;

    }

}

