package empDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class main {
	main() {
	}

	//int eno = 0;

	Scanner sc = new Scanner(System.in);

	public void addEmp() {
		try {
			Connection con = DatabaseConnection.getCon();
			//eno++;
			System.out.print("Enter employee's number :");
			int eno = sc.nextInt();
			System.out.print("Enter employee's name :");
			String ename = sc.next();
			System.out.print("Enter employee's Salary :");
			double salary = sc.nextDouble();

			String sql = "insert into empdata1 values (" + eno + ",'" + ename + "'," + salary + ")";
			System.out.println(sql);
			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
			ps1.executeUpdate();
			System.out.println("data feeded successfully!");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ViewAllEmp() {
		try {

			Connection con = DatabaseConnection.getCon();
			String sql = "select eno,ename,salary from empdata1";
			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps1.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getInt(1));
				System.out.print(",");
				System.out.print(rs.getString(2));
				System.out.print(",");
				System.out.print(rs.getDouble(3));
				System.out.println();
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeEmp() {
		try {
			Connection con = DatabaseConnection.getCon();
			System.out.print("enter employee number you want to delete record of :");
			int eno = sc.nextInt();

			String sql = "delete from empdata1 where eno=" + eno;
			PreparedStatement st1 = (PreparedStatement) con.prepareStatement(sql);
			st1.executeUpdate();
			System.out.println("Record deleted sucessfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearData() {
		try {
			Connection con = DatabaseConnection.getCon();
			PreparedStatement st1 = (PreparedStatement) con.prepareStatement("delete from empdata1");
			st1.executeUpdate();
			System.out.println("table deleted sucessfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSalary() {
		try {
			Connection con = DatabaseConnection.getCon();
			System.out.print("Entre employee number you want to update salary of :");
			int eno = sc.nextInt();
			System.out.print("Entre employee's updated salary :");
			double salary = sc.nextDouble();
			String sql = "update empdata1 set salary="+salary+" where eno="+eno+"";

			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
			//ps1.setDouble(1, salary);
			//ps1.setInt(2, eno);
			ps1.executeUpdate();
			System.out.println("table updated  successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchEmployee() {
		try {
			Connection con = DatabaseConnection.getCon();
			System.out.print("enter employee number you want to look details for :");
			int eno = sc.nextInt();

			String sql = "select eno,ename,salary from empdata1 where eno =" + eno;
			PreparedStatement ps1 = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps1.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1)+",");
				System.out.println(rs.getString(2)+",");
				System.out.println(rs.getDouble(3));
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("press 1 to add new Employee");
		System.out.println("press 2 view all Employee");
		System.out.println("press 3 to remove an Employee");
		System.out.println("press 4 to clear Date of all Employes");
		System.out.println("press 5 to change salary Employee");
		System.out.println("press 6 to search for an  Employee");
		System.out.println("press 7 to Exit");
		main m = new main();
		// m.addEmp();

		while (true) {
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				m.addEmp();
				break;
			case 2:
				m.ViewAllEmp();
				break;
			case 3:
				m.removeEmp();
				break;
			case 4:
				m.clearData();
				break;
			case 5:
				m.updateSalary();
				break;
			case 6:
				m.searchEmployee();
				break;
			case 7:
				break;
			default:
				System.out.println("Please Choose correct Option");
				break;
			}
		}

	}

}
