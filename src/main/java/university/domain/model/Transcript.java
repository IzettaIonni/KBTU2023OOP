package university.domain.model;

import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;

public class Transcript implements Serializable {

    @NonNull
    private Mark firstAttestationMark;
    @NonNull
    private Mark secondAttestationMark;
    @NonNull
    private Mark finalMark;
    @Nullable
    private Mark sumMark;

}
