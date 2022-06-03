package com.sncf.cad.model.location;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;
import javax.validation.constraints.Pattern;

@Data
public class UserLocationBatchRequest {

    @NotNull
    @Length(min = 23)
    @Pattern( regexp =("(^[0-9a-fA-F]{8}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{4}\b-[0-9a-fA-F]{12}) | (^[0-9a-fA-F]{24})") )
     private String userId;

    /**
     * Get the location records
     */
    private List<Location> locations;

}
