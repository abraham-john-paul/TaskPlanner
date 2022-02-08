package service;

import lombok.NonNull;
import model.*;
import model.strategy.IsCompletedTaskStrategy;
import repository.ObjectMappingRepository;
import repository.ObjectRepository;
import repository.StoryObjectRepository;
import repository.StoryToBugMappingObjectMappingRepository;

import java.util.ArrayList;
import java.util.List;

public class StoryService {
    private final ObjectMappingRepository<String, Bug> storyToBugObjectMappingRepository = new StoryToBugMappingObjectMappingRepository();
    private final ObjectRepository<String, Story> storyObjectRepository = new StoryObjectRepository();

    public boolean isCompleted(@NonNull final Story story) {
        var bugs = storyToBugObjectMappingRepository.getAll(story.getId());

        for (final var bug : bugs) {
            if (!bug.isCompleted(bug)) {
                return false;
            }
        }

        return true;
    }

    public List<Task> getDelayedTasks(@NonNull final Story story) {
        final List<Task> delayedTasks = new ArrayList<Task>();

        var bugs = storyToBugObjectMappingRepository.getAll(story.getId());
        for (var bug : bugs) {
           delayedTasks.addAll(bug.getDelayedTasks(bug));
        }

        return delayedTasks;
    }

    public Story createStory(@NonNull Developer developer, @NonNull Sprint sprint,
                               @NonNull String description, @NonNull IsCompletedTaskStrategy isCompletedTaskStrategy) {
        Story story = Story.builder()
                .developer(developer)
                .sprint(sprint)
                .description(description)
                .taskStatus(TaskStatus.NOT_STARTED)
                .taskType(TaskType.STORY)
                .isCompletedTaskStrategy(isCompletedTaskStrategy)
                .build();

        storyObjectRepository.add(story.getId(), story);

        return story;
    }

    public EpicStory createEpicStory(@NonNull final Epic epic, @NonNull Developer developer, @NonNull Sprint sprint,
                                     @NonNull String description, @NonNull IsCompletedTaskStrategy isCompletedTaskStrategy) {
        EpicStory story = EpicStory.builder()
                .developer(developer)
                .epic(epic)
                .sprint(sprint)
                .description(description)
                .taskStatus(TaskStatus.NOT_STARTED)
                .taskType(TaskType.STORY)
                .isCompletedTaskStrategy(isCompletedTaskStrategy)
                .build();

        storyObjectRepository.add(story.getId(), story);

        return story;
    }
}
