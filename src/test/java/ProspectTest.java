import Pages.LoginPage;
import Pages.ProspectPage;
import Utils.MyListener;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyListener.class)
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
