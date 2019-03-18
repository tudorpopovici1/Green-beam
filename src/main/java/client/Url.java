package client;

public enum Url {

    GET_MESSAGE("http://localhost:8080/greeting"),
    GET_USER("http://localhost:8080/rest/user"),
    GET_ALL_USERS("http://localhost:8080/rest/user/all"),
    ADD_USER("http://localhost:8080/rest/save/user"),
    GET_USER_FRIENDS("http://localhost:8080/rest/user/allfriends"),
    AUTH_USER("http://localhost:8080/token"),
    ADD_EMISSION("http://localhost:8080/rest/user/add/emission"),
    GET_EMISSION_FRIENDS("http://localhost:8080/rest/user/get/friends/emission"),
    GET_EMISSION_USER("http://localhost:8080/rest/user/get/all/emissions"),
    GET_TOP_FRIENDS_EMISSION("http://localhost:8080/rest/user/get/top/friends/emission");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

}
