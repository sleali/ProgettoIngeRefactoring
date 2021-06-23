public class ControllerMVC {
    private View view;
    private ControllerGRASP controller;

    public ControllerMVC(View view){
        this.view = view;
    }

    public void startView(){
        view.initMVC(this);
    }

    public void setControllerGRASP(ControllerGRASP controller){
        this.controller = controller;
    }

    public void startControllerGRASP(){
        controller.start(view);
    }
}
