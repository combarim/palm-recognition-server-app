package enset.ma.palmrecognitionserverapp.enums;

import jakarta.validation.constraints.NotNull;

public enum UserType {
    VISITOR,
    STAFF,
    BLACKLIST,
    ;

    public static UserType fromValue(@NotNull Integer type) {
        if(type == 1)
            return STAFF;
        else if (type == 2)
            return VISITOR;
        else if (type == 3)
            return BLACKLIST;
        else
            throw new IllegalArgumentException("Invalid user type: " + type);
    }

    public Integer toValue() {
        if(this == STAFF)
            return 1;
        else if (this == VISITOR)
            return 2;
        else if (this == BLACKLIST)
            return 3;
        else
            throw new IllegalArgumentException("Invalid user type: " + this);
    }
}
