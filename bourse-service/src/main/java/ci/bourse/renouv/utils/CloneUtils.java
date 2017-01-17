package ci.bourse.renouv.utils;

import org.springframework.beans.BeanUtils;

public final class CloneUtils {

    private CloneUtils() {}

    public static <T> T clone(final T source, final Class<T> clazz) {

        try {
            final T t = clazz.newInstance();
            BeanUtils.copyProperties(source, t);
            return t;
        } catch (final Exception e) {
            return null;
        }
    }

    public static <T, E extends T> E cloneTo(final T source,
            final Class<E> clazz) {

        try {
            final E e = clazz.newInstance();
            BeanUtils.copyProperties(source, e);
            return e;
        } catch (final Exception e) {
            return null;
        }
    }
}
