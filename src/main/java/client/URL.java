package client;

public enum URL {

    GET_MESSAGE ("http://localhost:8080/greeting"),
    GET_USER("http://localhost:8080/rest/user"),
    GET_ALL_USERS("http://localhost:8080/rest/user/all"),
    ADD_USER("http://localhost:8080/rest/save/user"),
    GET_USER_FRIENDS("http://localhost:8080/rest/user/allfriends"),
    AUTH_USER("http://localhost:8080/rest/user/auth");

    private String url;

    URL(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return this.url;
    }

}
