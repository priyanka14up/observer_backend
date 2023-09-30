package Observer20.payloads;

public class ChangeProfileStatusRequest {
    private String obscode;
    private boolean newProfileStatus;

    

    public ChangeProfileStatusRequest() {
    }

    public ChangeProfileStatusRequest(String obscode, boolean newProfileStatus) {
        this.obscode = obscode;
        this.newProfileStatus = newProfileStatus;
    }

    public String getObscode() {
        return obscode;
    }

    public void setObscode(String obscode) {
        this.obscode = obscode;
    }

    public boolean getNewProfileStatus() {
        return newProfileStatus;
    }

    public void setNewProfileStatus(boolean newProfileStatus) {
        this.newProfileStatus = newProfileStatus;
    }
}
