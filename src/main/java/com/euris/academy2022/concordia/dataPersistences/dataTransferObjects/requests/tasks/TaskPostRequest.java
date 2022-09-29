package com.euris.academy2022.concordia.dataPersistences.dataTransferObjects.requests.tasks;

import com.euris.academy2022.concordia.dataPersistences.dataArchetypes.DtoArchetype;
import com.euris.academy2022.concordia.dataPersistences.dataModels.Task;
import com.euris.academy2022.concordia.utils.enums.TaskPriority;
import com.euris.academy2022.concordia.utils.enums.TaskStatus;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskPostRequest implements DtoArchetype {

    private String title;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;
    private LocalDateTime deadLine;


    @Override
    public Task toModel() {
        return Task.builder()
                .title(title)
                .description(description)
                .priority(priority)
                .status(status)
                .deadLine(deadLine)
                .build();
    }
}