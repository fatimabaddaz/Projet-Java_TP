package phase2;

public class Note {

    private float note;
    private int id_E;
    private int id_M ;

    public Note() {
    }

    public Note(float note, int id_E, int id_M) {
        this.note = note;
        this.id_E= id_E;
        this.id_M= id_M;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
    public int getid_E() {
        return id_E;
    }

    public void setId(int id_E) {
        this.id_E = id_E;
    }

    

    public int getid_M() {
        return id_M;
    }

    public void setid_M(int id_M) {
        this.id_M = id_M;
    }
}

