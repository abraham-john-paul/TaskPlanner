package service;

import lombok.NonNull;
import model.Developer;
import model.SprintMaster;
import model.User;
import model.UserRole;
import repository.ObjectRepository;
import repository.UserObjectRepository;

public class UserService {
    private final ObjectRepository<String, User> userObjectRepository = new UserObjectRepository();

    public User addDeveloper(@NonNull final String name) {
        var developer = Developer.builder()
                .name(name)
                .role(UserRole.DEVELOPER)
                .build();
        userObjectRepository.add(developer.getId(), developer);

        return developer;
    }

    public User addSprintMaster(@NonNull final String name) {
        var sprintMaster = SprintMaster.builder()
                .name(name)
                .role(UserRole.SPRINT_MASTER)
                .build();
        userObjectRepository.add(sprintMaster.getId(), sprintMaster);

        return sprintMaster;
    }
}
