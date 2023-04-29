package edu.neu.madcourse.recyclerviewinternal;

/**
 * Interface definition for a callback to be invoked when certain events occur
 * in a RecyclerView.
 */
public interface RecyclerViewCallback {

    /**
     * Called when a RecyclerView creates a new ViewHolder.
     *
     * @param viewHoldersCreated the total number of ViewHolders created so far
     */
    void totalViewHoldersCreated(int viewHoldersCreated);

    /**
     * Called when the last method is called in a RecyclerView.
     *
     * @param methodName the name of the last method called
     */
    void lastMethodCalled(String methodName);

}

