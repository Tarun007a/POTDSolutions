package Leetcode;
// done by me using mp of mp and pq lazy remove
// leetcode - 1912 - hard

class MovieRentingSystem {
    class Movie {
        int shop;
        int number;
        int price;
        boolean active;

        public Movie(int shop, int number, int price) {
            this.shop = shop;
            this.number = number;
            this.price = price;
            this.active = true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(shop, number, price);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Movie movie = (Movie) o;
            return shop == movie.shop && number == movie.number && price == movie.price;
        }
    }

    private final Map<Integer, Map<Integer, Movie>> shopMap;
    private final Map<Integer, PriorityQueue<Movie>> moviesMap;
    private final PriorityQueue<Movie> rentedPq;
    private final Map<Integer, Map<Integer, Movie>> rentedMovie;

    public MovieRentingSystem(int n, int[][] entries) {
        shopMap = new HashMap<>();
        moviesMap = new HashMap<>();
        rentedMovie = new HashMap<>();
        rentedPq = new PriorityQueue<>((a, b) -> {
            if (a.price != b.price) return a.price - b.price;
            if (a.shop != b.shop) return a.shop - b.shop;
            return a.number - b.number;
        });

        for (int[] entry : entries) {
            int shop = entry[0];
            int movieId = entry[1];
            int price = entry[2];
            Movie movie = new Movie(shop, movieId, price);
            moviesMap.putIfAbsent(movieId, new PriorityQueue<>(
                    (a, b) -> a.price == b.price ? a.shop - b.shop : a.price - b.price
            ));
            moviesMap.get(movieId).add(movie);
            shopMap.putIfAbsent(shop, new HashMap<>());
            shopMap.get(shop).put(movieId, movie);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!moviesMap.containsKey(movie)) return result;
        PriorityQueue<Movie> pq = moviesMap.get(movie);
        Queue<Movie> temp = new ArrayDeque<>();
        int cnt = 0;
        while (cnt < 5 && !pq.isEmpty()) {
            Movie m = pq.poll();
            if (m.active) {
                result.add(m.shop);
                cnt++;
            }
            temp.add(m);
        }
        while (!temp.isEmpty()) pq.add(temp.poll());
        return result;
    }

    public void rent(int shop, int movie) {
        Movie curr = shopMap.get(shop).get(movie);
        curr.active = false;
        Movie rented = new Movie(shop, movie, curr.price);
        rentedMovie.putIfAbsent(shop, new HashMap<>());
        rentedMovie.get(shop).put(movie, rented);
        rentedPq.add(rented);
    }

    public void drop(int shop, int movie) {
        Movie curr = rentedMovie.get(shop).get(movie);
        curr.active = false;
        Movie newMovie = new Movie(shop, movie, curr.price);
        shopMap.get(shop).put(movie, newMovie);
        moviesMap.get(movie).add(newMovie);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Movie> temp = new ArrayDeque<>();
        int cnt = 0;
        while (cnt < 5 && !rentedPq.isEmpty()) {
            Movie m = rentedPq.poll();
            if (m.active) {
                result.add(Arrays.asList(m.shop, m.number));
                cnt++;
            }
            temp.add(m);
        }
        while (!temp.isEmpty()) rentedPq.add(temp.poll());
        return result;
    }
}