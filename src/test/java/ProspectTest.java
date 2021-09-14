import Pages.LoginPage;
import Pages.ProspectPage;

public class ProspectTest {


    public void createNewList() {

        new LoginPage()
                .login();

        new ProspectPage()
                .createNewList();

    }


    public void createNewFolder() {

        new LoginPage()

                .login();
        new ProspectPage()
                .createNewFolder();


    }


    public void deleteFolder() {
        new LoginPage()

                .login();
        new ProspectPage()
                .deleteFolder();

    }

}
