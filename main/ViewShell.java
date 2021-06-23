public class ViewShell implements View{
    private ControllerMVC controllerMVC;
    private ControllerGRASP controllerGRASP;

    @Override
    public void initMVC(ControllerMVC controller) {
        this.controllerMVC = controller;
    }

    @Override
    public void initGRASP(ControllerGRASP controller) {
        this.controllerGRASP = controller;
    }
}
