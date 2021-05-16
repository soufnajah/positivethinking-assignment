package org.positivethinking.najah.positivethinkingpartition.services;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class PartitionService implements
        IPartitionService {

    @Override
    public Stream<List<Integer>> partition(List<Integer> source, int length) {
        if(!Objects.nonNull(source))
            throw new IllegalArgumentException("Liste nulle, Impossible de continuer");
        if(CollectionUtils.isEmpty(source))
            throw new IllegalArgumentException("Liste Vide, Impossible de continuer");
        if (length <= 0)
            throw new IllegalArgumentException("Taille Positive requise: Mauvaise Valeur => " + length);
        int size = source.size();
        int elements = (size - 1) / length;
        return IntStream.range(0, elements + 1).mapToObj(
                n -> source.subList(n * length, n == elements ? size : (n + 1) * length));
    }
}