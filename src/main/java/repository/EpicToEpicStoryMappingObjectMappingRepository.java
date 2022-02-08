package repository;

import model.EpicStory;
import repository.exception.InvalidIdInRepoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EpicToEpicStoryMappingObjectMappingRepository implements ObjectMappingRepository<String, EpicStory> {
    Map<String, List<EpicStory>> epicStoryMap = new HashMap<>();

    @Override
    public void add(String epicId, EpicStory epicStory) {
        if (epicStoryMap.containsKey(epicId) == false) {
            epicStoryMap.put(epicId, new ArrayList<>());
        }
        var epicStories = epicStoryMap.get(epicId);
        epicStories.add(epicStory);
    }

    @Override
    public List<EpicStory> getAll(String epicId) {
        if (epicStoryMap.containsKey(epicId)) {
            var epicStories = epicStoryMap.get(epicId);
            return epicStories;
        }
        throw new InvalidIdInRepoException();
    }
}
