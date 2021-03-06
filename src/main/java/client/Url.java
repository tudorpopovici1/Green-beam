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
    GET_TOP_FRIENDS_EMISSION("http://localhost:8080/rest/user/get/top/friends/emission"),
    ADD_FRIEND("http://localhost:8080/rest/user/add/friend"),
    GET_FRIEND_REQ_SENT("http://localhost:8080/rest/user/get/friend/request/sent"),
    GET_FRIEND_REQ_REC("http://localhost:8080/rest/user/get/friend/request/received"),
    GET_ACHIEVEMENTS_USER("http://localhost:8080/rest/user/get/achievements"),
    SEARCH_FRIENDS("http://localhost:8080/rest/search"),
    GET_USERNAME("http://localhost:8080/rest/user/get"),
    GET_USER_USERNAME("http://localhost:8080/rest/user/get/username"),
    ACCEPT_FRIENDS("http://localhost:8080/rest//user/accept/friend"),
    REJECT_FRIENDS("http://localhost:8080/rest/user/reject/friend"),
    VEG_EMISSION("http://localhost:8080/rest/user/add/emission/vegMeal"),
    TRANSPORTATION_EMISSION("http://localhost:8080/rest/user/add/emission/transportation");

    private final String url;

    Url(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

}
