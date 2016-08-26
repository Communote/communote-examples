package com.communote.plugins.tutorial;
import java.util.ArrayList;
import java.util.List;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;

import com.communote.common.util.Pair;
import com.communote.server.api.core.note.NoteData;
import com.communote.server.api.core.note.NoteRenderContext;
import com.communote.server.api.core.note.NoteRenderMode;
import com.communote.server.api.core.note.processor.NoteContentRenderingPreProcessor;
import com.communote.server.api.core.note.processor.NoteRenderingPreProcessorException;
/**
 * @author <a href="http://github.com/communote">Communote Github Team</a>
 */
@Component
@Provides
@Instantiate(name = "TutorialNoteRenderingPreProcessor")
public class TutorialNoteRenderingPreProcessor implements NoteContentRenderingPreProcessor {

    // Definition of the replacements List
    private final static List<Pair<String, String>> REPLACEMENTS = new ArrayList<>();

    // On the left side of our pair are the placeholders and on the right side are the HTML replacements
    static {
        REPLACEMENTS.add(new Pair<>("[logo]", "<span class=\"communote-logo\"></span>"));
        REPLACEMENTS.add(new Pair<>("[github]", "<a href=\"http://github.com/communote\">Github Communote</a>"));
    }

    /**
     * @return the order value which is interpreted as the priority of the pre-processor. The higher
     *         the priority, the earlier this processor will be called.
     */
    @Override
    public int getOrder() {
        return DEFAULT_ORDER;
    }

    /**
     * @return whether the result can be cached. This method has to return false if this
     *         PreProcessor modifies the content in a way that depends on other NoteRenderContext
     *         attributes than the NoteRenderMode (e.g. locale, request attributes or modeOptions).
     *         This PreProcessor should not modify the note metadata (NoteListData object) while
     *         processing the content if this method returns true because the PreProcessor will not
     *         be invoked if the processed content was cached.
     */
    @Override
    public boolean isCachable() {
        return true;
    }

    /**
     * This methods searches for the placeholders and replaces them with the corresponding html entity.
     *
     * @param content
     *            The content to search and replace for.
     * @return The altered content.
     */
    private String processContent(String content) {
        // Do nothing if the content is null
        if (content == null) {
            return null;
        }

        // Searching for the "[logo]" and "[github] placeholder to replace them with the HTML defined above
        for (Pair<String, String> replacement : REPLACEMENTS) {
            content = content.replace(replacement.getLeft(), replacement.getRight());
        }
        return content;
    }

    /**
     * Processes a note for a specific render context. This method will only be called if the
     * processor supports the mode given by the render context.
     *
     * @param context
     *            holds details about the render context to allow specific processing in different
     *            situations
     * @param item
     *            the item to be processed
     * @return true if the item was modified, false otherwise
     * @throws com.communote.server.plugins.api.NoteRenderingPreProcessorException
     *             in case something unexpected lead to the failure of the processor
     */
    @Override
    public boolean processNoteContent(NoteRenderContext context, NoteData item)
            throws NoteRenderingPreProcessorException {
        // Setting the new content of the note delivered by the replacement function
        item.setContent(processContent(item.getContent()));
        // ... and do the same for the short preview content
        item.setShortContent(processContent(item.getShortContent()));
        return true;
    }

    /**
     * Denotes whether the pre-processor replaces the note content completely.
     *
     * @return true if the processor replaces the content and the shortened content completely. If
     *         the processor only modifies parts of the content or other members of the item, false
     *         should be returned. When replacing content the new content must match the render
     *         mode.
     */
    @Override
    public boolean replacesContent() {
        return false;
    }

    /**
     * Whether the processor supports a specific render mode. When returning true and the processor
     * modifies or replaces the note content it must ensure that it only inserts text which matches
     * the render mode, specifically the processor shouldn't insert HTML markup when called in PLAIN
     * mode.
     *
     * @param mode
     *            the note render mode, never null
     * @param note
     *            the note to render. A pre-processor can use this parameter to decide based on note
     *            attributes whether the note content should be processed
     * @return true if the mode can be handled by the processor, false otherwise
     */
    @Override
    public boolean supports(NoteRenderMode mode, NoteData item) {
        return NoteRenderMode.PORTAL.equals(mode);
    }
}
