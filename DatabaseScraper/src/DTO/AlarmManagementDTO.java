/*  1:   */
package DTO;

/*  2:   */
/*  3:   */ public class AlarmManagementDTO
        /*  4:   */ {
    /*  5:   */   private String[] m_phoneNoList;
    /*  6:   */   private String[] m_emailIdList;

    /*  7:   */
    /*  8:   */
    public String[] getPhoneNoList()
    /*  9:   */ {
        /* 10:16 */
        return this.m_phoneNoList;
        /* 11:   */
    }

    /* 12:   */
    /* 13:   */
    public void setPhoneNoList(String[] p_phoneNoList)
    /* 14:   */ {
        /* 15:21 */
        this.m_phoneNoList = p_phoneNoList;
        /* 16:   */
    }

    /* 17:   */
    /* 18:   */
    public String[] getEmailIdList()
    /* 19:   */ {
        /* 20:26 */
        return this.m_emailIdList;
        /* 21:   */
    }

    /* 22:   */
    /* 23:   */
    public void setEmailIdList(String[] p_emailIdList)
    /* 24:   */ {
        /* 25:31 */
        this.m_emailIdList = p_emailIdList;
        /* 26:   */
    }
    /* 27:   */
}



/* Location:           F:\WholeSaleBilling\WholeSaleBilling_v001\WebContent\WEB-INF\classes\

 * Qualified Name:     alarmmanagement.AlarmManagementDTO

 * JD-Core Version:    0.7.0.1

 */