package client.mainpage;

import client.Url;
import client.UserToken;
import client.services.ApiService;
import client.services.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.springframework.web.client.RestTemplate;
import server.model.FriendsUserResp;
import server.model.JwtUser;
import server.security.JwtValidator;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class SidePanelController implements Initializable {

    @FXML
    private JFXButton addFriendsButton;

    @FXML
    private JFXListView<String> friendslistView;

    @FXML
    private JFXTextField searchFriends;

    @FXML
    private JFXListView<String> foundFriends;

    @FXML
    private JFXButton searchButton;

    @FXML
    private Pane searchBarBox;

    @FXML
    private ImageView imageSidePanel;

    private RestTemplate restTemplate = new RestTemplate();
    private ApiService apiService = new ApiService();
    private UserService userService = new UserService();
    private JwtValidator jwtValidator = new JwtValidator();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<FriendsUserResp> friendsUserRespList = MainController.friendsListProfile;
        for(FriendsUserResp a : friendsUserRespList) {
            System.out.println(a.getUsername());
            friendslistView.getItems().add(a.getUsername());
        }
//        friendslistView.getItems().addAll("Iron Man", "Titanic");

        searchBarBox.setVisible(false);
    }

    /**
     * Activates the search bar.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void searchClicked(ActionEvent event) {
        searchBarBox.setVisible(false);
        foundFriends.getItems().clear();

        final String token = UserToken.getUserToken();
        JwtUser jwtUser = jwtValidator.validate(token);


        if (!(searchFriends.getText() == null) && !(searchFriends.getText().equals(""))) {
            List<FriendsUserResp> searchedFriends = userService.searchFriends(restTemplate, Url.SEARCH_FRIENDS.getUrl(), searchFriends.getText());
            for(FriendsUserResp a : searchedFriends) {
                foundFriends.getItems().add(a.getUsername());
            }
//            foundFriends.getItems().add(searchFriends.getText());
            searchBarBox.setVisible(true);
        }

    }

    /**
     * Closes the search bar.
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void backSidePanelClicked(ActionEvent event) {
        searchBarBox.setVisible(false);
        foundFriends.getItems().clear();

    }




    /**
     * Adds a friend to the friendslist
     * @param event - once a user clicks the button linked to
     *              this method, it starts to execute.
     */
    public void addFriendsClicked(ActionEvent event) {
        String friend = foundFriends.getSelectionModel().getSelectedItem();
        final String token = UserToken.getUserToken();
        JwtUser jwtUser = jwtValidator.validate(token);

        if (!(foundFriends.getSelectionModel().getSelectedItem() == null)){
            Long userid = userService.getUsername(restTemplate, Url.GET_USERNAME.getUrl(), friend, UserToken.getUserToken());
            String response = userService.addFriend(restTemplate, Url.ADD_FRIEND.getUrl(), jwtUser.getId(), userid, token);

            if(userid != -1) {
                if (response.equals("Saved")){
                    System.out.println("succesful");
                } else {
                    System.out.println("error");
                }
            } else {
                System.out.println("error");
            }

//            friendslistView.getItems().add(friend);
        }

        searchBarBox.setVisible(false);
    }



}
