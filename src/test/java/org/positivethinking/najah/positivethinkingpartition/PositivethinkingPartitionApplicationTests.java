package org.positivethinking.najah.positivethinkingpartition;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.positivethinking.najah.positivethinkingpartition.services.IPartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PositivethinkingPartitionApplicationTests {

    @Autowired
    IPartitionService partitionService;

    @Test
    public void contextLoads() {
        assertNotNull(partitionService.getClass());
    }

    @Test
    public void shouldReturn3Sublists() {

        // Given
        List liste = new ArrayList();
        for(int i=0;i<10;i++)
            liste.add(i*2);

        int taille = 3;

        // When
        Supplier<Stream<List<Integer>>> supplier = () ->
                partitionService.partition(liste, taille);

        // Then
        assertTrue(supplier.get().count() == 4);
        assertFalse( supplier.get().count() == 3);
        assertTrue(supplier.get().findAny().isPresent());
    }

    @Test
    public void shouldThrowAnException() {

        // Given
        List liste = new ArrayList();
        int taille = 3;

        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> partitionService.partition(liste, taille));
    }

    @Test
    public void shouldThrowAnException2() {

        // Given
        List liste = new ArrayList();
        for(int i=0;i<10;i++)
            liste.add(i*2);

        int taille = 0;

        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> partitionService.partition(liste, taille));

    }

    @Test
    public void shouldThrowAnException3() {

        // Given
        List liste = null;
        int taille = 3;

        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> partitionService.partition(liste, taille));
    }

    @Test
    public void shouldThrowAnException4() {

        // Given
        List liste = new ArrayList();
        for(int i=0;i<10;i++)
            liste.add(i*2);

        int taille = -3;

        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> partitionService.partition(liste, taille));
    }

}