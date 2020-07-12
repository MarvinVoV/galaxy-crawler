package com.galaxy.crawler.core.pipeline;

import com.galaxy.crawler.core.model.PipelineInput;
import com.galaxy.crawler.core.model.PipelineOutput;

/**
 * @author hufeng
 * @version Pipeline.java, v 0.1 2020/7/11 17:57 Exp $
 */

public interface Pipeline {
    PipelineOutput pipeline(PipelineInput input);
}
