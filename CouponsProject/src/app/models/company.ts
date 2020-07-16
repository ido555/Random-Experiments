export class Company {
  // credit to TypeScript ToolBox for auto generating 90% of this (lazy = efficent ;) )
  private companyId: number;
  private password: number;
  private name: string;
  private email: string;


  constructor($companyId: number, $password: number, $name: string, $email: string) {
    this.companyId = $companyId;
    this.password = $password;
    this.name = $name;
    this.email = $email;
  }

  /**
   * Getter $companyId
   * @return {number}
   */
  public get $companyId(): number {
    return this.companyId;
  }

  /**
   * Setter $companyId
   * @param {number} value
   */
  public set $companyId(value: number) {
    this.companyId = value;
  }

  /**
   * Getter $password
   * @return {number}
   */
  public get $password(): number {
    return this.password;
  }

  /**
   * Setter $password
   * @param {number} value
   */
  public set $password(value: number) {
    this.password = value;
  }

  /**
   * Getter $name
   * @return {string}
   */
  public get $name(): string {
    return this.name;
  }

  /**
   * Setter $name
   * @param {string} value
   */
  public set $name(value: string) {
    this.name = value;
  }

  /**
   * Getter $email
   * @return {string}
   */
  public get $email(): string {
    return this.email;
  }

  /**
   * Setter $email
   * @param {string} value
   */
  public set $email(value: string) {
    this.email = value;
  }

}
