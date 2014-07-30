package ca.bcit.comp2613.adoption.util;
   
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import java.util.ArrayList;

import ca.bcit.comp2613.adoption.model.AdoptiveMother;
import ca.bcit.comp2613.adoption.model.SortRecord;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Collections;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SearchAndCreateAdoptiveMother {

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

    public static ArrayList<AdoptiveMother> createAdoptiveMothers() {

        ArrayList<AdoptiveMother> retval = new ArrayList<AdoptiveMother>();
        String[] strs = LOREM_IPSUM.split("\\s");
        @SuppressWarnings("unused")
        Random random = new Random();

        // create loop
        for (int i = 0; i < 102; i++) {   
            int adoptiveMotherYearsWaiting = 0;
            AdoptiveMother AdoptiveMother = new AdoptiveMother(LOREM_IPSUM, LOREM_IPSUM, LOREM_IPSUM, LOREM_IPSUM);
            AdoptiveMother.setId(Integer.toString(i+1));
            AdoptiveMother.setFirstName(strs[i].toUpperCase());
            AdoptiveMother.setLastName(new StringBuilder(strs[i]).reverse().toString());
            
            adoptiveMotherYearsWaiting = ((int)(Math.random()*10));
            AdoptiveMother.setYearsWaiting(Integer.toString(adoptiveMotherYearsWaiting));            
            retval.add(AdoptiveMother);
        }
        return retval;
    }

    public static void printAdoptiveMothers(ArrayList<AdoptiveMother> AdoptiveMothers)
            throws IOException {
        log.info(propertiesConfiguration.getString("beginReport"));
        if (propertiesConfiguration.getBoolean("saveReportToFile")) {
            File file = new File("report.txt");
            for (AdoptiveMother AdoptiveMother : AdoptiveMothers) {
                log.info(AdoptiveMother);
                FileUtils.writeLines(file, AdoptiveMothers, true);
            }
        }
    }


    public static void save(List<AdoptiveMother> AdoptiveMothers, AdoptiveMother AdoptiveMother) {
        boolean foundUpdate = false;
        for (AdoptiveMother AdoptiveMotherLoop :AdoptiveMothers) {
            if (AdoptiveMotherLoop.getId().equals(AdoptiveMother.getId())) {
                AdoptiveMotherLoop.setFirstName(AdoptiveMother.getFirstName());
                AdoptiveMotherLoop.setLastName(AdoptiveMother.getLastName());
                AdoptiveMotherLoop.setYearsWaiting(AdoptiveMother.getYearsWaiting());
                foundUpdate = true;
                break;
            }
        }
        if (!foundUpdate) { // do an insert
            AdoptiveMothers.add(AdoptiveMother);
        }
    }

    public static void delete(List<AdoptiveMother> AdoptiveMothers, AdoptiveMother AdoptiveMother) {
        Iterator<AdoptiveMother> iter = AdoptiveMothers.iterator();
        while (iter.hasNext()) {
            AdoptiveMother AdoptiveMotherLoop = iter.next();
            if (AdoptiveMotherLoop.getId().equals(AdoptiveMother.getId())) {
                iter.remove();
                break;
            }
        }
    }
    
    public static void showComparableExample(ArrayList<AdoptiveMother> AdoptiveMothers) {
        ArrayList<SortRecord> myList = new ArrayList<SortRecord>();
        Collections.sort(myList);
        for (SortRecord AdoptiveMother : myList) {
            log.info(AdoptiveMother);
        }
    }

}

