package mockito;

public class Loggin {
    public WebService webService;
    public boolean isLogin;

    public Loggin(WebService webService){
        this.webService= webService;
        isLogin = false;
    }

    public void doLogin(){
        webService.login("Alberto", "1234", new Callback() {
            @Override
            public void onSucces(String response) {
                System.out
            }
        }
    }

}
