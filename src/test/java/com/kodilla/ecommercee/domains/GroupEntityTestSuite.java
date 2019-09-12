package com.kodilla.ecommercee.domains;

import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.repositories.GroupRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTestSuite {

    @Autowired
    GroupRepository repository;

    @Test
    public void groupSaveTest() {
        //Given
        Group group = new Group("test group");

        //When
        repository.save(group);
        long id = group.getGroupId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void groupReadTest() throws GroupNotFoundException {
        //Given
        Group group = new Group("test group");

        //When
        repository.save(group);
        long id = group.getGroupId();

        //Then
        Group resultGroup = repository.findById(id).orElseThrow(GroupNotFoundException::new);

        Assert.assertEquals("test group", resultGroup.getGroupName());

        //CleanUp
        repository.deleteById(id);
    }

    @Test
    public void groupUpdateTest() throws GroupNotFoundException {
        //Given
        Group group = new Group("test group");

        //When
        repository.save(group);
        long id = group.getGroupId();

        Group updatedGroup = repository.findById(id).orElseThrow(GroupNotFoundException::new);
        updatedGroup.setGroupName("updated group");

        repository.save(updatedGroup);
        Group result = repository.findById(id).orElseThrow(GroupNotFoundException::new);
        //Then

        Assert.assertEquals("updated group", result.getGroupName());

        //Clean Up
        repository.deleteById(id);
    }

    @Test
    public void groupDeleteTest() {
        //Given
        Group group = new Group("test group");

        //When
        repository.save(group);
        long id = group.getGroupId();
        long countBeforeDelete = repository.count();

        //Then
        repository.deleteById(id);
        long countAfterDelete = repository.count();

        Assert.assertEquals(countBeforeDelete - 1, countAfterDelete);
    }
}
