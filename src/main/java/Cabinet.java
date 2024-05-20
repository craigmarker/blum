import java.util.List;
import java.util.stream.Collectors;

/**
 * A <code>Cabinet</code> is the composition of an entire cabinet's construction, including the
 * box, storage solutions, materials, and dimensions.
 *
 * @author Craig Marker
 */
public class Cabinet {
    private final CabinetBox box;
    private final List<CabinetStorage> storage;

    private Cabinet(CabinetBox box, List<CabinetStorage> storage) {
        this.box = box;
        this.storage = storage;
    }

    public static Cabinet scaffold(CabinetBox box) {
        return new Cabinet(box, List.of());
    }

    public static Cabinet withStorage(CabinetBox box, List<CabinetStorage> storage) {
        return new Cabinet(box, storage);
    }

    public List<CabinetStorage> getStorage() {
        return storage;
    }

    public CabinetBox getBox() {
        return box;
    }

    @Override
    public String toString() {
        return "Cabinet{" + "box=" + box + ", storage=" + storage.stream().map(
                CabinetStorage::toString).collect(Collectors.joining(", ")) + '}';
    }
}
