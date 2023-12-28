package phase2;

public class Note {

    private float note;
    private int id_E;
    private int id_F ;

    public Note() {
    }

    public Note(float note, int id_E, int id_F) {
        this.note = note;
        this.id_E= id_E;
        this.id_F= id_F;
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

    

    public int getid_F() {
        return id_F;
    }

    public void setid_F(int id_F) {
        this.id_F = id_F;
    }
}

