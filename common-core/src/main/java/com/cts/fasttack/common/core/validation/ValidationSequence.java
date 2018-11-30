package com.cts.fasttack.common.core.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Minimal.class, Default.class})
public interface ValidationSequence {

}
