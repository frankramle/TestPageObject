
package com.sge.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

	@RunWith(Suite.class)
	
	@SuiteClasses({ IDT001_LoginTest.class, IDT002_HomeTest.class, IDT003_AgentesTest.class, IDT004_AgentesPerfilTest.class,
			IDT005_AgentesDatosFiscalesTest.class })
	
	public class AllTests {
	
	}
