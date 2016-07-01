/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bsc.confluence;

import org.bsc.functional.P1;

/**
 *
 * @author softphone
 */
public interface ConfluenceService {

    
        
    public interface Model {

        public interface Attachment {
                void setFileName(String name);
                String getFileName();

                void setContentType(String contentType);

                void setComment( String comment );

                java.util.Date getCreated();
        }            

        public interface PageSummary {
            
            String getId();
            
            String getTitle();
            
            String getSpace();
        }

        public interface Page extends PageSummary {

        }

    }
    

    Model.PageSummary findPageByTitle( String parentPageId, String title) throws Exception ;

    boolean removePage( Model.Page parentPage, String title ) throws Exception;

    void removePage( String pageId ) throws Exception;

    Model.Page getOrCreatePage( String spaceKey, String parentPageTitle, String title ) throws Exception ;

    Model.Page getOrCreatePage( Model.Page parentPage, String title ) throws Exception ;

    Model.Page getPage( String pageId ) throws Exception;

    Model.Page getPage( String spaceKey, String pageTitle ) throws Exception;

    boolean addLabelByName( String label, long id ) throws Exception;
    
    Model.Page storePage( Model.Page page, String content ) throws Exception;
    
    Model.Page storePage( Model.Page page ) throws Exception;
    
    java.util.List<Model.PageSummary> getDescendents(String pageId) throws Exception;

    
    void exportPage(    String url, 
                        String username, 
                        String password, 
                        String spaceKey, 
                        String pageTitle, 
                        ExportFormat exfmt, 
                        java.io.File outputFile) throws Exception;
    
    String getVersion();

    void call(P1<ConfluenceService> task) throws Exception;
    
    //
    // ATTACHMENT
    //
    
    /**
     * factory method
     * 
     * @return 
     */
    Model.Attachment createAttachment(); 
    
    Model.Attachment getAttachment( String pageId, String name, String version) throws Exception;
    
    Model.Attachment addAttchment( Model.Page page, Model.Attachment attachment, java.io.InputStream source ) throws Exception ;

    
}