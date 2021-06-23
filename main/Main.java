public class Main {
    public static void main(String[] args){
        ControllerMVC application = new ControllerMVC(new ViewShell());
        application.startView();
    }
}
