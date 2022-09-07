

package com.tamil.szchattools.commons.models;

import androidx.annotation.Nullable;

import com.tamil.szchattools.messages.MessageHolders;

/*
 * Created by sz
 */

/**
 * Interface used to mark messages as custom content types. For its representation see {@link MessageHolders}
 */

public interface MessageContentType extends IMessage {

    /**
     * Default media type for image message.
     */
    interface Image extends IMessage {
        @Nullable
        String getImageUrl();
    }

    // other default types will be here

}
