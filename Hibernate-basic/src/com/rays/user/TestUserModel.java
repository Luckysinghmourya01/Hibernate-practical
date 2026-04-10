package com.rays.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.rays.exception.DublicateRecordException;

public class TestUserModel {

	public static void main(String[] args) throws ParseException, DublicateRecordException {

		// testAdd();
		// testFindByLogin();
		// testAuthenticate();
		testAuthenticate1();
	}

	private static void testAuthenticate1() {

		UserModel model = new UserModel();
		UserDTO dto = new UserDTO();

		dto = model.authenticate1("aman66@gmail.com", "man11than22");
		if (dto != null) {

			System.out.print("\t" + dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getAddress());
			System.out.print("\t" + dto.getDob());
		} else {
			System.out.println("invalid loginId or password");
		}

	}

	private static void testAuthenticate() {

		UserModel model = new UserModel();
		UserDTO dto = new UserDTO();

		dto = model.authenticate("aman66@gmail.com", "man11than22");
		if (dto != null) {

			System.out.print("\t" + dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getAddress());
			System.out.print("\t" + dto.getDob());
		} else {
			System.out.println("invalid loginId or password");
		}

	}

	private static void testFindByLogin() {

		UserDTO dto = new UserDTO();
		UserModel model = new UserModel();

		dto = model.findByLogin("aman66@gmail.com");
		if (dto != null) {

			System.out.print("\t" + dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getAddress());
			System.out.print("\t" + dto.getDob());
		}

	}

	private static void testAdd() throws ParseException, DublicateRecordException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserDTO dto = new UserDTO();
		UserModel model = new UserModel();

		dto.setFirstName("aman");
		dto.setLastName("singh");
		dto.setLoginId("aman66@gmail.com");
		dto.setPassword("man11than22");
		dto.setAddress("mhow");
		dto.setDob(sdf.parse("2005-1-21"));

		model.add(dto);

	}
}
