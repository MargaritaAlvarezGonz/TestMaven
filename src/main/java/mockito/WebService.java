package mockito;


public class WebService {
    public void login(String user, String pasword, Callback callback){
        if (checkLogin(user, pasword)){
            callback.onSucces("Usuario Correct");
        }else{
            callback.onFail("Error")
        }
    }
    public boolean checkLogin(String user, String password){
        if (user.equals("Alberto")&& password.equals("1234")){
            return true;
        }return false;
    }
}
