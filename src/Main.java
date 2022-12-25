
class Scriptwriter {
    public Script writeScript() {
        System.out.println("Сценарист написал сценарий");
        return new Script();
    }
}

class Actor {
    public Role playRole(Script script)
    {
        System.out.println("Актер сыграл свою роль");
        return new Role();
    }
}

class FilmDirector {
    public RawMaterial captureScenes(Role role) {
        System.out.println("Режиссер снял сцены");
        return new RawMaterial();
    }
}

class Videoeditor {
    public ReadyFilm editFilm(RawMaterial rawMaterial)
    {
        System.out.println("Видеомонтажер смонтировал фильм");
        return new ReadyFilm();
    }
}

class Producer {
    public ReleasFilm releasingFilm(ReadyFilm readyFilm) {
        System.out.println("Продюссер запустил фильм в прокат");
        return new ReleasFilm();
    }
}

class FilmCapture { //Фасад
    private Scriptwriter scriptwriter = new Scriptwriter();
    private Actor actor = new Actor();
    private FilmDirector filmDirector = new FilmDirector();
    private Videoeditor videoeditor = new Videoeditor();
    private Producer producer = new Producer();

    public void StartCaptureFilm() {
        producer.releasingFilm(videoeditor.editFilm(filmDirector.captureScenes(actor.playRole(scriptwriter.writeScript()))));
        System.out.println("Фильм снят");
    }
}

public class Main {
    public static void main(String[] args) {
        FilmCapture filmCapture = new FilmCapture();
        filmCapture.StartCaptureFilm();
    }
}
