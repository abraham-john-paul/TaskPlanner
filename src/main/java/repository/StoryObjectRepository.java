package repository;

import model.Story;
import repository.exception.InvalidIdInRepoException;

import java.util.HashMap;
import java.util.Map;

public class StoryObjectRepository implements ObjectRepository<String, Story> {
    Map<String, Story> storyMap= new HashMap<>();
    @Override
    public void add(String storyId, Story story) {
        storyMap.put(storyId, story);
    }

    @Override
    public Story get(String storyId) {
        if (storyMap.containsKey(storyId)) {
            var story = storyMap.get(storyId);
            return story;
        }
        throw new InvalidIdInRepoException();
    }
}
