package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class for all reports. Implements the Template Method pattern.
 */
public abstract class Report {
    
    // Template Method - defines the report generation workflow
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    // Steps to be implemented by subclasses
    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}

