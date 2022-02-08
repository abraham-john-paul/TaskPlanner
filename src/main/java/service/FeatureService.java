package service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import model.*;
import model.strategy.IsCompletedTaskStrategy;
import repository.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FeatureService {
    private final ObjectRepository<String, Feature> featureObjectRepository = new FeatureObjectRepository();
    private final ObjectMappingRepository<String, Epic> featureToEpicObjectMappingRepository = new FeatureToEpicMappingObjectMappingRepository();
    private final ObjectMappingRepository<String, EpicStory> epicToEpicStoryObjectMappingRepository = new EpicToEpicStoryMappingObjectMappingRepository();
    private final StoryService storyService = new StoryService();

    boolean IsCompleted(@NonNull final Feature feature) {
        var epics = featureToEpicObjectMappingRepository.getAll(feature.getId());
        for (var epic : epics) {
            var epicStories = epicToEpicStoryObjectMappingRepository.getAll(epic.getId());
            for (final var epicStory : epicStories) {
                if (!storyService.isCompleted(epicStory)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Task> getDelayedTasks(@NonNull final Feature feature) {
        List<Task> delayedTasks = new ArrayList<Task>();

        var epics = featureToEpicObjectMappingRepository.getAll(feature.getId());
        for (var epic : epics) {
            var epicStories = epicToEpicStoryObjectMappingRepository.getAll(epic.getId());
            for (final var epicStory : epicStories) {
                delayedTasks.addAll(storyService.getDelayedTasks(epicStory));
            }
        }

        return delayedTasks;
    }

    public Feature createFeature(@NonNull Developer developer, @NonNull Sprint sprint,
                                 @NonNull String description, @NonNull IsCompletedTaskStrategy isCompletedTaskStrategy) {
        Feature feature = Feature.builder()
                .developer(developer)
                .sprint(sprint)
                .description(description)
                .taskStatus(TaskStatus.NOT_STARTED)
                .taskType(TaskType.FEATURE)
                .isCompletedTaskStrategy(isCompletedTaskStrategy)
                .build();

        featureObjectRepository.add(feature.getId(), feature);

        return feature;
    }

//    public void addEpic
}
