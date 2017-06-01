package helper;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PowerSet {

    private static <T> Set<T> copyWithout(Collection<T> s, T e) {
        Set<T> result = new HashSet<>(s);
        result.remove(e);
        return result;
    }

    private static <T> Set<T> copyWith(Collection<T> s, T e) {
        Set<T> result = new HashSet<>(s);
        result.add(e);
        return result;
    }

    public static <T> Set<Set<T>> powerset(Collection<T> s) {
        Set<Set<T>> result = new HashSet<>();
        if (s.isEmpty()) {
            Set<T> empty = Collections.emptySet();
            result.add(empty);
        } else {
            for (T e : s) {
                Set<T> t = copyWithout(s, e);
                Set<Set<T>> ps = powerset(t);
                result.addAll(ps);
                for (Set<T> ts : ps) {
                    result.add(copyWith(ts, e));
                }
            }
        }
        return result;
    }
}