package Model.Film;

import java.util.List;

public interface InterfaceDAOFilm {
    public void insert(ModelFilm Film);
    public void update(ModelFilm Film);
    public void delete(int id);
    public List<ModelFilm> getAll();
    public void deleteAll();
}
