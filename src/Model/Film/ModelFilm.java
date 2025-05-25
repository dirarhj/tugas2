package Model.Film;

public class ModelFilm {
    private int id;
    private String judul;
    private float alur;
    private float penokohan;
    private float akting;
    private float rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public float getAlur() {
        return alur;
    }

    public void setAlur(float alur) {
        this.alur = alur;
    }

    public float getPenokohan() {
        return penokohan;
    }

    public void setPenokohan(float penokohan) {
        this.penokohan = penokohan;
    }

    public float getAkting() {
        return akting;
    }

    public void setAkting(float akting) {
        this.akting = akting;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
