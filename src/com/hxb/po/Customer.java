package com.hxb.po;

/**
 * The type Customer.
 *
 * @author 和学博
 */
public class Customer {
    //id
    private Integer id;
    //客户名称
    private String username;
    //职业
    private String jobs;
    //电话
    private String phone;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Integer getId() {
        return id;
    }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Integer id) {
        this.id = id;
    }

  /**
   * Gets username.
   *
   * @return the username
   */
  public String getUsername() {
        return username;
    }

  /**
   * Sets username.
   *
   * @param username the username
   */
  public void setUsername(String username) {
        this.username = username;
    }

  /**
   * Gets jobs.
   *
   * @return the jobs
   */
  public String getJobs() {
        return jobs;
    }

  /**
   * Sets jobs.
   *
   * @param jobs the jobs
   */
  public void setJobs(String jobs) {
        this.jobs = jobs;
    }

  /**
   * Gets phone.
   *
   * @return the phone
   */
  public String getPhone() {
        return phone;
    }

  /**
   * Sets phone.
   *
   * @param phone the phone
   */
  public void setPhone(String phone) {
        this.phone = phone;
    }
}
