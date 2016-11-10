import org.jacop.constraints.XneqY;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.DepthFirstSearch;
import org.jacop.search.IndomainMin;
import org.jacop.search.InputOrderSelect;
import org.jacop.search.Search;
import org.jacop.search.SelectChoicePoint;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        // define finite domain variables
        int size = 4;
        IntVar[] v = new IntVar[size];
        for (int i = 0; i < size; i++)
            v[i] = new IntVar(store, "v" + i, 1, size);
        // define constraints
        store.impose(new XneqY(v[0], v[1]));
        store.impose(new XneqY(v[0], v[2]));
        store.impose(new XneqY(v[1], v[2]));
        store.impose(new XneqY(v[1], v[3]));
        store.impose(new XneqY(v[2], v[3]));
// search for a solution and print results
        Search<IntVar> search = new DepthFirstSearch<IntVar>();
        SelectChoicePoint<IntVar> select =
                new InputOrderSelect<IntVar>(store, v,
                        new IndomainMin<IntVar>());
        search.labeling(store, select);
    }

}
