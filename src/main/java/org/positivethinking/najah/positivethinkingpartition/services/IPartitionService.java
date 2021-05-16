package org.positivethinking.najah.positivethinkingpartition.services;

import java.util.List;
import java.util.stream.Stream;

public interface IPartitionService {
    Stream<List<Integer>> partition(List<Integer> source, int length);
}