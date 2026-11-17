

public class User {
    private String name;
    private FavouriteList favourites;
    protected String id;



    public User(String id) {
        this.id = id;
        this.favourites = new FavouriteList();

    }

    public FavouriteList getFavourites() {
        return favourites;
    }

    public void setFavourites(FavouriteList favourites) {
        this.favourites = favourites;
    }

    public String getName() {
        return this.name;
    }


}
