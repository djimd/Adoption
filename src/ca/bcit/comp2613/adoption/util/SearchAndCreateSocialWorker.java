package ca.bcit.comp2613.adoption.util;
 
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import java.util.ArrayList;

import ca.bcit.comp2613.adoption.model.SocialWorker;
import ca.bcit.comp2613.adoption.model.Region;
import ca.bcit.comp2613.adoption.model.SortRecord;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Collections;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SearchAndCreateSocialWorker {

    public static Logger log = Logger.getLogger(SearchAndCreateHelper.class);
    public static PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();

    static {
        PropertyConfigurator.configure(SearchAndCreateHelper.class
                .getResourceAsStream("log4j.properties"));
        try {
            propertiesConfiguration.load(SearchAndCreateHelper.class
                    .getResourceAsStream("adoption.properties"));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    };

    public static String LOREM_IPSUM = "ANITA RHONDA HAZEL AMBER EVA DEBBIE APRIL LESLIE CLARA LUCILLE JAMIE JOANNE ELEANOR VALERIE DANIELLE"
            + "SHANNON SHEILA ETHEL ELLEN ELAINE MARJORIE CARRIE CHARLOTTE MONICA ESTHER PAULINE EMMA JUANITA"
            + "EDNA TIFFANY CARMEN ROSA CINDY GRACE WENDY VICTORIA EDITH KIM SHERRY SYLVIA JOSEPHINE THELMA"
            + "SHIRLEY CYNTHIA ANGELA MELISSA BRENDA AMY ANNA REBECCA VIRGINIA KATHLEEN PAMELA MARTHA DEBRA"
            + "SHIRLEY CYNTHIA ANGELA MELISSA BRENDA AMY ANNA REBECCA VIRGINIA KATHLEEN PAMELA MARTHA DEBRA"        
            + "MARILYN ANDREA KATHRYN LOUISE SARA ANNE JACQUELINE WANDA BONNIE JULIA RUBY LOIS TINA PHYLLIS"
            + "JANICE KELLY NICOLE JUDY CHRISTINA KATHY THERESA BEVERLY DENISE TAMMY IRENE JANE LORI RACHEL"
            + "HEATHER TERESA DORIS GLORIA EVELYN JEAN CHERYL MILDRED KATHERINE JOAN ASHLEY JUDITH ROSE"
            + "AMANDA STEPHANIE CAROLYN CHRISTINE MARIE JANET CATHERINE FRANCES ANN JOYCE DIANE ALICE JULIE"
            + "SHIRLEY CYNTHIA ANGELA MELISSA BRENDA AMY ANNA REBECCA VIRGINIA KATHLEEN PAMELA MARTHA DEBRA"
            + "BETTY HELEN SANDRA DONNA CAROL RUTH SHARON MICHELLE LAURA SARAH KIMBERLY DEBORAH JESSICA"
            + "MARY PATRICIA LINDA BARBARA ELIZABETH JENNIFER MARIA SUSAN MARGARET DOROTHY LISA NANCY KAREN";

    public static ArrayList<SocialWorker> createSocialWorkers() {

        ArrayList<SocialWorker> retval = new ArrayList<SocialWorker>();
        String[] strs = LOREM_IPSUM.split("\\s");
        Random random = new Random();

        // create loop
        for (int i = 0; i < 102; i++) {   
            SocialWorker SocialWorker = new SocialWorker();
            SocialWorker.setId(Integer.toString(i+1));
            SocialWorker.setFirstName(strs[i].toUpperCase());
            SocialWorker.setLastName(new StringBuilder(strs[i]).reverse().toString());
            SocialWorker.setRegion(Region.values()[random.nextInt(Region.values().length)]);
            
            retval.add(SocialWorker);
        }
        return retval;
    }

    public static void printSocialWorkers(ArrayList<SocialWorker> SocialWorkers)
            throws IOException {
        log.info(propertiesConfiguration.getString("beginReport"));
        if (propertiesConfiguration.getBoolean("saveReportToFile")) {
            File file = new File("report.txt");
            for (SocialWorker SocialWorker : SocialWorkers) {
                log.info(SocialWorker);
                FileUtils.writeLines(file, SocialWorkers, true);
            }
        }
    }


    public static void save(List<SocialWorker> SocialWorkers, SocialWorker SocialWorker) {
        boolean foundUpdate = false;
        for (SocialWorker SocialWorkerLoop :SocialWorkers) {
            if (SocialWorkerLoop.getId().equals(SocialWorker.getId())) {
                SocialWorkerLoop.setFirstName(SocialWorker.getFirstName());
                SocialWorkerLoop.setLastName(SocialWorker.getLastName());
                SocialWorkerLoop.setRegion(SocialWorker.getRegion());
                foundUpdate = true;
                break;
            }
        }
        if (!foundUpdate) { // do an insert
            SocialWorkers.add(SocialWorker);
        }
    }

    public static void delete(List<SocialWorker> SocialWorkers, SocialWorker SocialWorker) {
        Iterator<SocialWorker> iter = SocialWorkers.iterator();
        while (iter.hasNext()) {
            SocialWorker SocialWorkerLoop = iter.next();
            if (SocialWorkerLoop.getId().equals(SocialWorker.getId())) {
                iter.remove();
                break;
            }
        }
    }
    
    public static void showComparableExample(ArrayList<SocialWorker> SocialWorkers) {
        ArrayList<SortRecord> myList = new ArrayList<SortRecord>();
        Collections.sort(myList);
        for (SortRecord SocialWorker : myList) {
            log.info(SocialWorker);
        }
    }

}

