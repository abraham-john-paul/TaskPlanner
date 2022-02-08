package repository;

import model.Bug;
import repository.exception.InvalidIdInRepoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoryToBugMappingObjectMappingRepository implements ObjectMappingRepository<String, Bug> {
    private final Map<String, List<Bug>> storyBugMap = new HashMap<>();
    @Override
    public void add(String storyId, Bug bug) {
        if (storyBugMap.containsKey(storyId) == false) {
            storyBugMap.put(storyId, new ArrayList<>());
        }
        var bugs = storyBugMap.get(storyId);
        bugs.add(bug);
    }

    @Override
    public List<Bug> getAll(String storyId) {
        if (storyBugMap.containsKey(storyId)) {
            var bugs = storyBugMap.get(storyId);
            return bugs;
        }
        throw new InvalidIdInRepoException();
    }
}
